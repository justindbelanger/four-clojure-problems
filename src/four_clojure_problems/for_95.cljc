(ns four-clojure-problems.for-95)

;; depth-first or breadth-first? I don't think breadth-first is possible in this situation.
;; is it a tree: is it nil or a sequence of three elements? are the second and third elements trees?
;; if i could iterate over the roots of each tree, in one sequence, then i'd be able to check each one
;; loop over both siblings
;; if nil, then true
(def is-binary-tree? (fn check-tree [maybe-tree]
                       (or (nil? maybe-tree)
                           (and (sequential? maybe-tree)
                                (= (count maybe-tree) 3)
                                (check-tree (second maybe-tree))
                                (check-tree (nth maybe-tree 2))))))
