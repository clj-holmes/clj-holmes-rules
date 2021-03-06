# clj-holmes rules
Open source rules used by [clj-holmes](https://github.com/clj-holmes/clj-holmes).

# Rule syntax
The rule syntax is defined by the spec defined [here](https://github.com/clj-holmes/clj-holmes/blob/main/src/clj_holmes/specs/rule.clj).

## Fields
### id
A short, unique and descriptive identifier for the rule.
### name
A short description for the rule.
### severity
The severity of the finding. This is useful for filtering security issues when viewing SARIF outputs uploaded to GitHub, for example.
### message
A more descriptive message for the rule that specifies in detail what the rule is looking for.
### properties
A dictionary that provides metadata about the rule.
#### precision
The precision of the finding. This is useful for filtering security issues when viewing SARIF outputs uploaded to GitHub, for example.
#### tags
A list of markers to make possible using only a subset of rules when scanning a project. 

### Pattern Description (patterns/patterns-either)
A dictionary with configurable parameters that are necessary to finding relevant code. These fields can be nested as to provide enough expressive power to match almost any code. The engine will resolve the innermost pattern and work its way out until all Pattern Descriptions are solved.
A Pattern Description can also be collection of Pattern Expressions.
#### patterns
A collection of Patterns Descriptions. Matches when all Pattern Descriptions inside also match. Functionally equivalent to doing a `AND` of all Pattern Descriptions inside.
#### patterns-either
A collection of Patterns Descriptions. Matches when at least one Pattern Description inside also match. Functionally equivalent to doing a `OR` of all Pattern Descriptions inside.

#### Pattern Expression (pattern/pattern-not)
A Pattern Expression as documented in [shape-shifter](https://github.com/clj-holmes/shape-shifter).
##### pattern
Pattern Expression to search for. Matches when pattern is found on code.
##### pattern-not
Pattern Expression to search for. Matches when pattern is not found on code.
#### custom-function?
Boolean flag to indicate if finding a `custom-funciton` is required. The presence of this flag forces `clj-holmes` to use the `function` and `namespace` fields to find usages of `function` called via a full `namespace`, a `namespace` alias or simply when using `:refer` or `:refer :all`.
#### function
The function to be matched.
#### namespace
The namespace where the function being searched for comes from.
#### interpret-regex?
Boolean flag to indicate if there's a regex in the `pattern` that needs to be interpreted and searched.
