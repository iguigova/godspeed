(ns godspeed.core-test
  (:require [midje.sweet :refer :all]
            [godspeed.core :refer :all]))

(fact "ca-forecast should return a weather report"
      (contains? (ca-forecast "test") :text) => true
      (contains? (ca-forecast "test") :iconUrl) => true)
        

