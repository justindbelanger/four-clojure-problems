(ns four-clojure-problems.for-56)

;; * first try

(def find-distinct-items-transducer
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

;; * second try

(def find-distinct-items-nested-ifs
  (fn [s]
    (let [f (fn f
              ([s]
               (f s #{}))
              ([s tracked]
               (let [head (first s)
                     tail (rest s)
                     new? (not (contains? tracked head))
                     end? (not (seq tail))]
                 (if end?
                   (if new?
                     (list head)
                     (list))
                   (if new?
                     (lazy-seq (cons head (f tail (conj tracked head))))
                     (lazy-seq (f tail tracked)))))))]
      (f s))))

;; * third try

(def find-distinct-items-cond
  (fn [s]
    (let [f (fn f
              ([s]
               (f s #{}))
              ([s tracked]
               (let [head (first s)
                     tail (rest s)
                     new? (not (contains? tracked head))
                     end? (not (seq tail))]
                 (cond
                   (and new? end?)
                   (list head)

                   new?
                   (lazy-cat (list head) (f tail (conj tracked head)))

                   end?
                   (list)

                   :else
                   (lazy-seq (f tail tracked))))))]
      (f s))))

;; * fourth try

(def find-distinct-items-sets
  (fn [s]
    (let [f (fn f
              ([s]
               (f s #{}))
              ([s tracked]
               (let [head         (first s)
                     head-set     #{head}
                     tail         (rest s)
                     new          (clojure.set/difference head-set tracked)
                     next-tracked (clojure.set/union head-set tracked)
                     end?         (not (seq tail))]
                 (lazy-cat new (if end?
                                 (list)
                                 (f tail next-tracked))))))]
      (f s))))
