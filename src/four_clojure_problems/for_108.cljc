(ns four-clojure-problems.for-108)

(defn seqs-contain-number?
  [seqs the-number]
  (let [possible-matches (map #(drop-while (fn [other-number]
                                             (< other-number the-number))
                                           %)
                              seqs)]
    (every? #(= (first %)
                the-number)
            possible-matches)))

;; for each seq
;; if the seq is empty, skip it
;; check whether all of the others contain the first number in the seq
;; if so, return the number
;; if not, remove the number and start over
(defn lazy-search
  [& seqs]
  (loop [remaining seqs]
    (let [not-empty   (filter seq remaining)
          chosen-seq  (first not-empty)
          others      (rest not-empty)
          current     (first chosen-seq)
          in-all-seqs (seqs-contain-number? others
                                            current)]
      (if in-all-seqs
        current
        (recur (cons (rest chosen-seq)
                     others))))))

;; gotta be able to copy & paste into 4clojure.com
(def lazy-search-solution
  (fn [& seqs]
    (letfn [(seqs-contain-number? [seqs the-number]
              (let [possible-matches (map #(drop-while (fn [other-number]
                                                         (< other-number the-number))
                                                       %)
                                          seqs)]
                (every? #(= (first %)
                            the-number)
                        possible-matches)))]
      (loop [remaining seqs]
        (let [not-empty   (filter seq remaining)
              chosen-seq  (first not-empty)
              others      (rest not-empty)
              current     (first chosen-seq)
              in-all-seqs (seqs-contain-number? others
                                                current)]
          (if in-all-seqs
            current
            (recur (cons (rest chosen-seq)
                         others))))))))
