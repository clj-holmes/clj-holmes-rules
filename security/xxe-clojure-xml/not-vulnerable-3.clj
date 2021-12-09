(ns vulnerable-2)

(defn parse
  ([input]
   (parse input identity))
  ([input deserialize-fn]
   (deserialize-fn input)))

(def not-vulnerable [x]
  (parse x))
