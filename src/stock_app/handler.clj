(ns stock-app.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/oauth/token" [] "{\"access_token\": \"abcdefg\"}")
  (POST "/api/stocks/buy" req "{\"order-status\": \"EXECUTED\"}")
  (POST "/api/stocks/sell" []"{\"order-status\": \"EXECUTED\"}")
  (POST "/api/options/put" []"{\"order-status\": \"EXECUTED\"}")
  (POST "/api/options/call" []"{\"order-status\": \"EXECUTED\"}")
  (GET "/api/stocks/quote" [] "{\"symbol\": \"APPL\", \"price\" 72.0, \"currency\": \"USD\"}")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
