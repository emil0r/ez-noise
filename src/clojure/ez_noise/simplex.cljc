(ns ez-noise.simplex
  (:import [EzSimplex OpenSimplexNoise]))

(defn simplex
  ([] (simplex 0))
  ([^Long seed] (OpenSimplexNoise. seed)))

(defn noise
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y] (.eval simplex-noise x y))
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y, ^Double z] (.eval simplex-noise x y z))
  ([^OpenSimplexNoise simplex-noise, ^Double x, ^Double y, ^Double z, ^Double w] (.eval simplex-noise x y z w)))
