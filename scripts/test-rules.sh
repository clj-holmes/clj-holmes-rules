#!/bin/bash

echoerr() {
    RED='\033[0;31m'
    NC='\033[0m' # No Color
    echo -e "${RED}$@${NC}" 1>&2;
}

rule_path=$(dirname $1)
rule_name="$(basename ${1%.*})"
rule_example_code="$rule_path/"
rule_expected_output_file="$rule_path/$rule_name.json"

PATH="$PATH:/tmp"

clj-holmes scan -p $rule_example_code -d "$1" -t json -o /tmp/$rule_name.json --no-verbose

if [[ -a "$rule_expected_output_file" ]]; then
    check_equality=$(jd "/tmp/$rule_name.json" "$rule_expected_output_file")
    if [[ -z $check_equality ]]; then
        echo "Rule $rule_name is working as expected."
        exit 0
    else
        echoerr "Rule $rule_name is not working as expected."
        exit 1
    fi
else
    echoerr "Rule $rule_name will not be tested since it does not have an example code or an expected output file"
fi
