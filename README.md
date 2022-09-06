# data-struct
data struct &amp; leetcode demo

# leetcode config

1. code filename
```shell
Code$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})

```
2. code template
```shell
${question.content}

package cn;
/**
 * @author cloaks
 * @questionId ${question.frontendQuestionId}
 * @title ${question.title}
 * @titleSlug ${question.titleSlug}
 * @date $!velocityTool.date()
 */
public class Code$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    ${question.code}
}
```
3. temp file path is project root
> example: ~/data-struct