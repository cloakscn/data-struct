package golang

import (
	"strconv"
	"testing"
)

func TestIsPalindrome(t *testing.T) {
	num := int64(11)

	for {
		if isPalindrome(num) {
			t.Logf("num: %v is palindrome", num)
			t.Logf("binary: %v", strconv.FormatInt(num, 2))
			t.Logf("octal: %v", strconv.FormatInt(num, 8))
			t.Logf("decimal: %v", strconv.FormatInt(num, 10))
			break
		}

		num += 2
	}
}
