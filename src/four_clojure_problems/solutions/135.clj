(ns four-clojure-problems.solutions.135
  (:require [clojure.test :refer [deftest is]]))

;; if it's a number, then hold onto it in a well-known place and read the next element
;; except if we already have an operator, in which case we must recall the previous number and the operator, then apply the operator to the two operands, then return the result
;; if it's an operator, hold onto it in a different well-known place and read the next element
(def infix-calc (fn [& expr]
                  (let [operators #{+ / - *}]
                    (loop [operator nil
                           operands '()
                           remaining expr]
                      (let [head (first remaining)
                            found-operator (operators head)]
                        (if (empty? remaining)
                          (apply operator (reverse (take 2 operands)))
                          (recur (or found-operator operator)
                                 (cond
                                   (and found-operator operator) (conj (drop 2 operands) (apply operator (reverse (take 2 operands))))
                                   (not found-operator) (conj operands head)
                                   :else operands)
                                 (rest remaining))))))))

(deftest infix-calc-tests
  (is (= (infix-calc 2 + 5)
         7))
  (is (= (infix-calc 38 + 48 - 2 / 2)
         42))
  (is (= (infix-calc 10 / 2 - 1 * 2)
         8))
  (is (= (infix-calc 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)
         72)))

;; exercise: support operator precedence
;; what's required? if visiting an operator, check whether it's lower or greater precedence than the previous operator. if lower, grab the previous operator and previous two operands, evaluate them, and store the result. otherwise, just store the operator and continue.
;; seems the commonalities are storing the result, storing at least one operator and operand, and evaluating an expression.
;; bedmas/pemdas
#_()

;; perhaps it's like creating a tree
;; operators with a lesser precedence end up at a lesser depth in the tree
;; e.g. 10 / 2 - 1 * 2
;;     -
;;   /   *
;; 10 2 1 2
;; although... hmm... with no precedence, we get
;;   / - *
;; 10 2 1 2
;; I guess we could make it more like
;;       *
;;     -  2
;;   /  1
;; 10 2
;; we could say, 'match one operand, one operator, and another operand' and then repeat with the transformed sequence
;; then we say we're providing the lazy sequence of the depth-first, in-order traversal of the tree and gradually transform that into a single value
;; the interesting thing is that we're parsing and applying, rather than doing them as separate steps
