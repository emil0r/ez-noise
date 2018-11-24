(ns ez-noise.simplex
  (:import [EzSimplex OpenSimplexNoise]))

(defn simplex
  ([] (simplex 0))
  ([^Long seed] (OpenSimplexNoise. seed)))

(def constant 1.14942)

(defn noise
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y] (* constant (.eval ^Double simplex-noise x y)))
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y, ^Double z] (* ^Double constant (.eval simplex-noise x y z)))
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y, ^Double z, ^Double w] (* ^Double constant (.eval simplex-noise x y z w))))
