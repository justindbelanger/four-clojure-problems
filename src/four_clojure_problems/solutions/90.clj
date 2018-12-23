(ns four-clojure-problems.solutions.90)

(def cartesian-product (fn [s t]
                         (reduce (fn [result si]
                                   (clojure.set/union result (set (map (fn [ti]
                                                                         [si ti])
                                                                       t))))
                                 #{}
                                 s)))

(def examples [{:input [#{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"}]
                :result #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
                          ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
                          ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}}
               {:input [#{1 2 3} #{4 5}]
                :result #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}}
               {:input ((into #{} (range 10))
                        (into #{} (range 30)))
                :process count
                :result 300}])
