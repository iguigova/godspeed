(ns godspeed.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [godspeed.core :refer :all]))

(defroutes app-routes
  ;;(GET "/" [] "Hello World")            
  (GET "/api/forecast" [code] (response (ca-forecast code)))
  (route/not-found "Not Found"))

(def app ( ->
          app-routes
          (wrap-json-response)
          (wrap-defaults site-defaults)))
