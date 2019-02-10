(ns four-clojure-problems.for-113-test
  (:require [four-clojure-problems.for-113 :refer [data-dance]]
            [clojure.test :refer [deftest is]]))

(deftest data-dance-tests
  (is (= (str (data-dance 2 1 3))
         "1, 2, 3"))
  (is (= (seq (data-dance 2 1 3))
         '(2 1 3)))
  (is (= (seq (data-dance 2 1 3 3 1 2))
         '(2 1 3)))
  (is (= (seq (apply data-dance (repeat 5 1)))
         '(1)))
  (is (= (str (apply data-dance (repeat 5 1)))
         "1, 1, 1, 1, 1"))
  (is (and (= nil (seq (data-dance)))
           (= "" (str (data-dance))))))
