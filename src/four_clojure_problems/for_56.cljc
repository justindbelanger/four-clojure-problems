(ns four-clojure-problems.for-56)

(def find-distinct-items
  (fn [s]
    (let [transducer (fn [rf]
                       (let [*tracked (atom #{})]
                         (fn
                           ;; init
                           ([] (rf))
                           ;; finalize
                           ([result] (rf result))
                           ;; accumulate
                           ([result input]
                            (if (contains? @*tracked input)
                              result ;; drop anything we've seen before
                              (do
                                (swap! *tracked conj input)
                                (rf result input)))))))]
      (transduce transducer conj [] s))))
