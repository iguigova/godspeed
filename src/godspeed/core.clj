(ns godspeed.core
  (:require [clojure.string :as str]
            [clojure.data.json :as json1]
            [cheshire.core :as json]
            [org.httpkit.client :as client]))

(defn ca-forecast [code]
  (let [response @(client/get "https://weather.gc.ca/api/app/en/Location/BC-81?type=city" {:accept :json})]
    (if (= 200 (:status response))
      (let [forecast (first (json/parse-string (:body response) true))
            report (select-keys (first (:daily(:dailyFcst forecast))) [:text :titleText :summary])
            report (merge report (select-keys (first (:hourly(:hourlyFcst forecast))) [:windDir :windSpeed :iconCode :precip :temperature])) 
            report (merge report (select-keys forecast [:lastUpdated :lat :lon :cityCode :displayName :alert])) 
            report (merge report {:iconUrl (str "https://weather.gc.ca/weathericons/" (:iconCode report) ".gif")})
            ]
        report
        ))
    ))
