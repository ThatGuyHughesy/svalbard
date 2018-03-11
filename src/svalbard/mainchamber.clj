(ns svalbard.mainchamber
  (:require [clojure.string :as s]))

(def debug-output "HHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHUNTTGTGTGTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNORHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHRHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGATGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNTGTGGNRHTGTGGNRHGNRHNTTGRHHHHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGGNRHNTTGRHHHHHGNNTTGTGTGTGTGGNRHERHHHHHGNHHGNHHGNHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTGHHGNHHGNGNRHNTTG")

(defn revert-rules [code]
  "Revert the defined rules for letter pairing"
  (-> code
      (s/replace #"GN" "G")
      (s/replace #"NT" "R")
      (s/replace #"RH" "N")
      (s/replace #"TG" "H")
      (s/replace #"HH" "T")))

(defn seed->letter-pairings [seed]
  "Split seed into letter pairings"
  (s/replace seed #".{2}" #(str % " ")))

(defn letter-pairings->seed [letter-pairings]
  "Remove whitespaces to merge letter pairings back into seed"
  (s/replace letter-pairings #" " ""))

(defn single->double-vowels [code]
  "Double each vowel as rules are for letter pairings: 2 => 1"
  (s/replace code #"[AEIOU]" #(str % %)))

(defn double->single-vowels [code]
  "Apply letter pairing rule to vowels: 2 => 1"
  (s/replace code #"[AEIOU]{2}" #(subs % 1)))

(defn revert-seeding [seed current-generation generations]
  "Revert the seeding process"
  (if (< current-generation generations)
    (-> seed
        (seed->letter-pairings)
        (revert-rules)
        (letter-pairings->seed)
        (revert-seeding (+ current-generation 1) generations))
    seed))

(-> debug-output
    (single->double-vowels)
    (revert-seeding 0 7)
    (double->single-vowels)
    (println))
