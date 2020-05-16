(ns four-clojure-problems.for-128)

(def recognize-playing-card
  (fn [card]
    (let [suits {"D" :diamond
                 "H" :heart
                 "C" :club
                 "S" :spade}
          ranks {"2" 0
                 "3" 1
                 "4" 2
                 "5" 3
                 "6" 4
                 "7" 5
                 "8" 6
                 "9" 7
                 "T" 8
                 "J" 9
                 "Q" 10
                 "K" 11
                 "A" 12}
          suit  (str (first card))
          rank  (str (second card))]
      {:suit (get suits suit)
       :rank (get ranks rank)})))
