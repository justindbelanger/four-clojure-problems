(ns four-clojure-problems.for-122-test
  (:require [four-clojure-problems.for-122 :as sut]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest binary-to-decimal-test
  (let [bin->dec sut/binary-to-decimal]
    (is (= 0 (bin->dec "0")))
    (is (= 7 (bin->dec "111")))
    (is (= 8 (bin->dec "1000")))
    (is (= 9 (bin->dec "1001")))
    (is (= 255 (bin->dec "11111111")))
    (is (= 1365 (bin->dec "10101010101")))
    (is (= 65535 (bin->dec "1111111111111111")))))
