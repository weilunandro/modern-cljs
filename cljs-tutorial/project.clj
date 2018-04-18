(defproject cljs-tutorial "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.3.4"
  :clean-targets ["out" :target-path]
  :source-paths ["src/clj" "src/cljs" "resources/tools/http" "resources/tools/repl"]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring "1.6.3"]
                 [compojure "1.6.1"]
                 [enlive "1.1.6"]
                 [org.clojure/clojurescript "1.10.238"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [com.cemerick/austin "0.1.6"]]
  
  :hooks [leiningen.cljsbuild]
  
  :cljsbuild
  {:builds {:cljs-tutorial
            {:source-paths ["src/cljs" "resources/tools/repl"]
             :compiler
             {:output-dir "resources/public/js"
              :output-to "resources/public/js/cljs_tutorial.js"
              :source-map "resources/public/js/cljs_tutorial.js.map"
              :optimizations :whitespace
              :pretty-print true}}}}
  :injections [(require '[ring.server :as http :refer [run]]
                        'cemerick.austin.repls)
               (defn browser-repl []
                 (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                          (cemerick.austin/repl-env))))])
