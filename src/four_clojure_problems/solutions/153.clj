(ns four-clojure-problems.solutions.153)

(defn combinations [s]
  "Provides the lazy sequence of all 2-element combinations of the given seqable."
  (let [elements (vec s)
        length (count elements)
        indices (range length)]
    (for [i indices
          j indices
          :when (not= i j)]
      (let [get-both-indices (juxt #(nth % i) #(nth % j))]
        (get-both-indices elements)))))

(def disjoint? (fn disjoint-fn
                 ([s t] (= #{} (clojure.set/intersection s t)))
                 ([ss] (every? #(apply disjoint-fn %) (combinations ss)))))

(def solution (fn disjoint-fn
                ([s t] (= #{} (clojure.set/intersection s t)))
                ([ss] (every? #(apply disjoint-fn %)
                              (letfn [(combinations-fn [s]
                                        (let [elements (vec s)
                                              length (count elements)
                                              indices (range length)]
                                          (for [i indices
                                                j indices
                                                :when (not= i j)]
                                            (let [get-both-indices (juxt #(nth % i) #(nth % j))]
                                              (get-both-indices elements)))))]
                                (combinations-fn ss))))))

(def examples [{:input #{#{:a :b :c :d :e}
                         #{:a :b :c :d}
                         #{:a :b :c}
                         #{:a :b}
                         #{:a}}
                :result false}
               {:input #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}
                :result true}
               {:input #{#{[1 2 3] [4 5]}
                         #{[1 2] [3 4 5]}
                         #{[1] [2] 3 4 5}
                         #{1 2 [3 4] [5]}}
                :result true}
               {:input #{#{'a 'b}
                         #{'c 'd 'e}
                         #{'f 'g 'h 'i}
                         #{''a ''c ''f}}
                :result true}
               {:input #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                         #{#{:x :y :z} #{:x :y} #{:z} #{}}
                         #{'[:x :y :z] [:x :y] [:z] [] {}}}
                :result false}
               {:input #{#{(= "true") false}
                         #{:yes :no}
                         #{(class 1) 0}
                         #{(symbol "true") 'false}
                         #{(keyword "yes") ::no}
                         #{(class '1) (int \0)}}
                :result false}
               {:input #{#{distinct?}
                         #{#(-> %) #(-> %)}
                         #{#(-> %) #(-> %) #(-> %)}
                         #{#(-> %) #(-> %) #(-> %)}}
                :result true}
               {:input #{#{(#(-> *)) + (quote mapcat) #_ nil}
                         #{'+ '* mapcat (comment mapcat)}
                         #{(do) set contains? nil?}
                         #{, , , #_, , empty?}}
                :result false}])

(->> examples
     (map (fn [e]
        (->> e
             ((juxt #(-> %
                         :input
                         disjoint?)
                    :result))
             (apply =))))
     (every? true?)
    assert)
