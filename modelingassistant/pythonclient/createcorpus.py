#!/usr/bin/env python3

from fileserdes import save_to_files
from corpus_creation import corpus

if __name__ == "__main__":
    "Main entry point."
    save_to_files({"modelingassistant.learningcorpus.dsl.instances/default.learningcorpus": corpus})
