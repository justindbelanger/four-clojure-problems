(ns four-clojure-problems.for-103-test
  (:require [four-clojure-problems.for-103 :as sut]
            #?(:clj [clojure.test :refer [deftest is testing]]
               :cljs [cljs.test :refer-macros [deftest is]])))

(deftest k-combinations-test
  (is (= #{#{4} #{5} #{6}}
         (sut/k-combinations 1 #{4 5 6})))
  (is (= #{}
         (sut/k-combinations 10 #{4 5 6})))
  (is (= #{#{0 1} #{0 2} #{1 2}}
         (sut/k-combinations 2 #{0 1 2})))
  (is (= #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
           #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}
         (sut/k-combinations 3 #{0 1 2 3 4})))
  (is (= #{#{[1 2 3] :a "abc" "efg"}}
         (sut/k-combinations 4 #{[1 2 3] :a "abc" "efg"})))
  (is (= #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
           #{:a "abc"} #{:a "efg"} #{"abc" "efg"}}
         (sut/k-combinations 2 #{[1 2 3] :a "abc" "efg"}))))
