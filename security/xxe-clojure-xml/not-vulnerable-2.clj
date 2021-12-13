(ns vulnerable-1
  (:require [clojure.xml :as xml]))

(defn startparse-sax-no-doctype [s ch]
  (..
    (doto (javax.xml.parsers.SAXParserFactory/newInstance)
      (.setFeature "http://apache.org/xml/features/disallow-doctype-decl" true)
      (.setFeature "http://xml.org/sax/features/external-general-entities" false)
      (.setFeature "http://xml.org/sax/features/external-parameter-entities" false))
    (newSAXParser)
    (parse s ch)))

(def not-vulnerable [input]
  (clojure.xml/parse input startparse-sax-no-doctype))
