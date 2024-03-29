(ns svalbard.tunnel
  (:require [clojure.string :as s]))

; Removing ) at end of code to be correct JSFuck syntax returns this
(def char-codes [102, 111, 114, 40, 118, 97, 114, 32, 105, 61, 48, 59, 105, 60, 108, 101, 110, 59, 105, 43, 43, 41, 123, 98, 117, 102, 102, 101, 114, 43, 61, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 39, 82, 79, 79, 84, 83, 79, 70, 76, 73, 70, 69, 39, 91, 105, 93, 59, 117, 110, 100, 101, 102, 105, 110, 101, 100, 125])

(defn char-codes->string [char-codes]
  "Convert list of char codes into string"
  (->> (map
         (fn [char-code]
           (char char-code))
         char-codes)
       (apply str)))

(->> char-codes
     (char-codes->string)
     (re-find #"[A-Z]+")
     (println))