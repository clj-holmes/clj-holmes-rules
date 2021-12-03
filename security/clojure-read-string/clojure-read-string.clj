(ns clojure-read-string
  (:require [clojure.edn :as edn]))

(defn vulnerable [x]
  (read-string x))

(defn not-vulnerable [x]
  (edn/read-string x))
