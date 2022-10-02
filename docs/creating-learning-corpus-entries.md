# Creating Learning Corpus Entries

This file describes the steps to create a new learning corpus entry, corresponding to a mistake type.

## Prerequisites

* Python project set up as described in
[the setup doc](docs/onboarding/setup.md).
* Background knowledge of the Modeling Assistant and Learning Corpus, including the metamodels.
  See the project documentation for more information.

## Steps

### Step 1: Update Corpus Definition

The learning corpus is currently defined in the `modelingassistant/learningcorpusinstances/default.learningcorpus` file
based on what is specified in the `corpusdefinition.py` file.

1. Add a new mistake type (mt) to the corpus definition file in the correct mistake type category (mtc), or add
   a new category. Use the appropriately named helper functions for this (`mt` and `mtc`), and add at least one
   feedback:

   ```python
   missing_class := mt(n="Missing class", stud=[], inst="cls", feedbacks=fbs({
       1: Feedback(highlightProblem=True),
   })),
   ```

   Note that `missing_class` is a variable which must match the lowercase name (`n`) of the mistake type,
   with spaces and dashes replaced by underscores. Also note the `:=` (used to define the named expression)
   and the trailing commas.
   Student and instructor `MistakeElement`s are specified using the `stud` and `inst`
   parameters, respectively. If both are the same, `stud_inst` can be used instead.
   If there is only one element, it can be specified directly as a string instead of
   using a list as in the example above.

2. Add the mistake type to the priority list in the corpus definition file.

### Step 2: Update Corpus Instance

To update the learning corpus instance stored on disk, as well as the Java and Python code,
run the following command:

```bash
python modelingassistant/pythonapp/createcorpus.py
```

### Step 3: Update Source Code

Update the Java and Python logic to correctly handle the new mistake type, as needed.

### Step 4: Run tests

Run all Python and Java tests and ensure that all tests that were passing
continue to pass.
