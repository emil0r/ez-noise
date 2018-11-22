(ns test
  (:require [ez-simplex.core :refer [simplex noise]]
            [mikera.image.core :as image]
            [mikera.image.colours :as colours]))

(defn flatten-value [v]
  (long (* 256 (/ (+ 0.87 v) (* 0.87 2)))))

(defn grey [v]
  (let [v (long v)]
    (colours/rgb-from-components v v v)))

(defn- calculcate-octave [x y frequency amp])
(defn octave [simplex num-iterations x y persistence scale low high]
  (let [{:keys [n max-amp]}
        (reduce (fn [{:keys [n amp frequency max-amp] :as out} _]
                  {:n (+ n (* amp (noise simplex (* frequency x) (* frequency y))))
                   :max-amp (+ amp max-amp)
                   :amp (* amp persistence)
                   :frequency (* frequency 2)})
                {:n 0
                 :amp 1
                 :max-amp 0
                 :frequency scale} (range 1 (inc num-iterations)))
        n (* 1.14942 (/ n max-amp))]
    (+ (* n (/ (- high low) 2))
       (/ (+ high low) 2))))


(let [[width height] [256 256]
      img (image/new-image width height)
      simplex (simplex)]
  (doseq [x (range width)]
    (doseq [y (range height)]
      (image/set-pixel img x y (grey (octave simplex 16 x y 0.5 0.01 0 255)))))
  (image/save img "test.png"))

(def numbers (atom []))

(do (reset! numbers [])
    (let [simplex (simplex)]
      (doseq [x (range 1024)]
        (doseq [y (range 1024)]
          (swap! numbers conj [x y (long (octave simplex 1 x y 0.5 0.01 0 255))]))))
    (println (take 20 @numbers)))

(apply max (map last @numbers))

(let [simplex (simplex)]
  (map #(noise simplex (* 1 %) 0) (range 10)))
