(ns svalbard.vault
  (:require [clojure.string :as s]))

(def template-strand "TACGATGCATGGCTACYZZWXVAVYZTTAGACTAGCACTCGA")

(def protein-bonds {"T" "A"
                    "A" "T"
                    "G" "C"
                    "C" "G"
                    "V" "U"
                    "W" "N"
                    "X" "F"
                    "Y" "R"
                    "Z" "E"})

(defn template-strand->base-pairs [template-strand]
  "Convert template strand in DNA base pairs"
  (->> (seq template-strand)
       (map
         (fn [protein]
           [(get protein-bonds (str protein)) protein]))))

(defn base-pairs->non-template-strand [base-pairs]
  "Retrieve non-template strand from base pairs"
  (->> (map
         (fn [base-pair]
           (first base-pair))
         base-pairs)
       (apply str)))

(-> template-strand
    (template-strand->base-pairs)
    (base-pairs->non-template-strand)
    (println))