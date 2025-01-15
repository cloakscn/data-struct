package golang

import "strconv"

func reverse(s string) string {
	// 将字符串转换为rune切片（处理多字节字符）
	runes := []rune(s)
	// 双指针法翻转rune切片
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func IsPalindrome(num int64) bool {
	binary := strconv.FormatInt(num, 2)
	if reverse(binary) != binary {
		return false
	}

	octal := strconv.FormatInt(num, 8)
	if reverse(octal) != octal {
		return false
	}

	decimal := strconv.FormatInt(num, 10)
	if reverse(decimal) != decimal {
		return false
	}

	return true
}
