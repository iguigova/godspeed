(defproject godseepd "0.0.1-SNAPSHOT"
  ;; https://github.com/poenneby/practical-clojure
  :description "Forecast winds"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.4.0"]
                 [cheshire "5.12.0"]
                 [http-kit "2.6.0"]
                 [compojure "1.7.0"]
                 [ring/ring-json "0.5.1"]
                 [ring/ring-defaults "0.4.0"]]
  :plugins [[lein-ring "0.12.6"]]
  :ring {:handler godspeed.handler/app}
  :profiles {:dev {:dependencies [[midje "1.9.4"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]]}})
