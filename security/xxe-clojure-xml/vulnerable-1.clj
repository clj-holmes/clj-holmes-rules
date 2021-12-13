(ns vulnerable-1
  (:require [clojure.xml :as xml]))

(defn vulnerable [x]
  (clojure.xml/parse x))
