(ns clojure-weak-ssl-context
  (:import [javax.net.ssl SSLContext]))

(def context (SSLContext/getInstance "SSL"))
