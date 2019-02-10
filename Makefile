.PHONY: test

test:
	clj -Atest-clj && clj -Atest-cljs
