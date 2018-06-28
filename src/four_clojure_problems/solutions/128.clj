(ns four-clojure-problems.solutions.128)

(def recognize-playing-card (fn [card]
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
                                    suit (str (first card))
                                    rank (str (second card))]
                                {:suit (get suits suit)
                                 :rank (get ranks rank)})))

(def tests [{:input "DQ" :result {:suit :diamond :rank 10}}])

(defn test-fn []
  (= (recognize-playing-card (get-in tests [0 :input]))
     (get-in tests [0 :result])))
