(ns ez-noise.simplex
  (:import [EzSimplex OpenSimplexNoise]))

(defn simplex
  ([] (simplex 0))
  ([^Long seed] (OpenSimplexNoise. seed)))

(defn noise
  ([^OpenSimplexNoise simplex-noise, ^Long x, ^Long y] (.eval simplex-noise x y))
  ([^OpenSimplexNoise simplex-noise, ^Long x, ^Long y, ^Long z] (.eval simplex-noise x y z))
  ([^OpenSimplexNoise simplex-noise, ^Long x, ^Long y, ^Long z, ^Long w] (.eval simplex-noise x y z w)))
