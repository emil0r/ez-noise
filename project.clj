(defproject ez-noise "0.1.1"

  :description "Noise implementations for clojure"

  :url "https://github.com/emil0r/ez-noise"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["dev" "src/clojure"]

  :java-source-paths ["src/java"]

  :dependencies [[org.clojure/clojure "1.8.0"]]

  :profiles {:dev {:dependencies [[net.mikera/imagez "0.12.0"]]}})
