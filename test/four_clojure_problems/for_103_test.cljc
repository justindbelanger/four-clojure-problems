(ns four-clojure-problems.for-103-test
  (:require [four-clojure-problems.for-103 :as sut]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest k-combinations-test
  (is (= #{#{4} #{5} #{6}}
         (sut/f 1 #{4 5 6}))))
