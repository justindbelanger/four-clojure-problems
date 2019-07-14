(ns four-clojure-problems.for-96-test
  (:require [four-clojure-problems.for-96 :as sut]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest symmetree-tests
  (testing "Binary trees that are symmetrical should result in truthy value."
    (is (sut/has-symmetree? '(:a (:b nil nil) (:b nil nil))))
    (is (sut/has-symmetree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                             [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])))
  (testing "Binary trees that are not symmetrical should result in a falsy value."
    (is (not (sut/has-symmetree? '(:a (:b nil nil) nil))))
    (is (not (sut/has-symmetree? '(:a (:b nil nil) (:c nil nil)))))
    (is (not (sut/has-symmetree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                  [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])))
    (is (not (sut/has-symmetree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                  [2 [3 nil [4 [6 nil nil] nil]] nil]])))))
