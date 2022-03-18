(ns clojure-read-string
  (:refer-clojure :exclude [read read-string]))

(defn read-string [^"[B" v]
  (String. v))

(defn not-vulnerable [x]
  (read-string x))
