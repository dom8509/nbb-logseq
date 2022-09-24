(ns nbb.impl.cljs-http
  {:no-doc true}
  (:require [cljs-http.core :as core]
            [cljs-http.client :as client]
            [nbb.core :as nbb]
            [sci.core :as sci :refer [copy-var]]))

(def core-ns (sci/create-ns 'cljs-http.core nil))
(def client-ns (sci/create-ns 'cljs-http.client nil))

(def core-namespace
  {'request (copy-var core/request core-ns)
   'jsonp (copy-var core/jsonp core-ns)})

(def client-namespace
  {'get (copy-var client/get client-ns)
   'head (copy-var client/head client-ns)
   'put (copy-var client/put client-ns)
   'post (copy-var client/post client-ns)})

(defn init []
  (nbb/register-plugin!
   ::cljs-http
   {:namespaces {'cljs-http.core   core-namespace
                 'cljs-http.coerce client-namespace}}))
