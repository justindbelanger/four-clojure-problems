(ns four-clojure-problems.for-77)

;; for each other word in the collection,
;; check whether all of its letters are in the the target word
(defn find-anagrams-for-word
  [word all-words]
  (let [set-of-letters #(into #{} (seq %))
        word-letters   (set-of-letters word)]
    (->> all-words
         (filter (fn [other-word]
                   (= word-letters
                      (set-of-letters other-word))))
         (into #{}))))

;; only words with at least one anagram (so a set of two items) should be included
(defn find-anagrams
  [words]
  (->> words
       (map (fn [word]
              (find-anagrams-for-word word
                                      words)))
       (filter (fn [anagrams]
                 (>= (count anagrams)
                     2)))
       (into #{})))

;; have to be able to copy & paste the entire solution into a text box on 4clojure
(def find-anagrams-solution
  (fn [words]
    (letfn [(find-anagrams-for-word [word all-words]
              (let [set-of-letters #(into #{} (seq %))
                    word-letters   (set-of-letters word)]
                (->> all-words
                     (filter (fn [other-word]
                               (= word-letters
                                  (set-of-letters other-word))))
                     (into #{}))))]
      (->> words
           (map (fn [word]
                  (find-anagrams-for-word word
                                          words)))
           (filter (fn [anagrams]
                     (>= (count anagrams)
                         2)))
           (into #{})))))
