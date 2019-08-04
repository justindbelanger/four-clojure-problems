(ns four-clojure-problems.for-70-test
  (:require [four-clojure-problems.for-70 :as sut]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest sorting-test
  (is (= (sut/word-sorting "Have a nice day.")
         ["a" "day" "Have" "nice"]))
  (is (= (sut/word-sorting "Clojure is a fun language.")
         ["a" "Clojure" "fun" "is" "language"]))
  (is (= (sut/word-sorting "Fools fall for foolish follies.")
         ["fall" "follies" "foolish" "Fools" "for"])))
