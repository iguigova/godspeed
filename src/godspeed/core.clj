(ns godspeed.core
  (:require [clojure.string :as str]
            [cheshire.core :refer [parse-string]]))

(defn monuments-by-region [monuments region]
  (filter (fn [m] (str/starts-with? (:REG m) region)) monuments))

(defn winds [code] "as fast as I can")

(defn search-forecast [code]
  (parse-string (slurp "https://weather.gc.ca/api/app/en/Location/BC-81?type=city")))
