(ns godspeed.core-test
  (:require [midje.sweet :refer :all]
            [godspeed.core :refer :all]))

(facts "about `winds`"
  (fact "it should return as fast as I can"
        (winds "test") => "as fast as I can")
  (fact "it should return json"
        (empty? (search-forecast "test")) => false?)
  (fact "it should return monuments matching part of region name"
    (let [monuments '({:REG "Picardie"})
          region "P"]
    (monuments-by-region monuments region) => monuments)))
