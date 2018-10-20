(ns four-clojure-problems.solutions.41)

(def drop-nth (fn [ss number]
                (->> ss
                     (map-indexed (fn [i s]
                                    [(inc i) s]))
                     (filter (fn [[i s]]
                               (not (zero? (rem i number)))))
                     (map second))))

(def tests [{:input [[1 2 3 4 5 6 7 8] 3]
             :result [1 2 4 5 7 8]}
            {:input [[:a :b :c :d :e :f] 2]
             :result [:a :c :e]}
            {:input [[1 2 3 4 5 6] 4]
             :result [1 2 3 5 6]}])
