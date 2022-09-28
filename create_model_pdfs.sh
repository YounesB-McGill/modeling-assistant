#!/usr/bin/env bash

# This script is used to create the PDFs for the modeling assistant application metamodels,
# including the TouchCORE ClassDiagram metamodels, from their SVG versions created by the Eclipse Aird editor.
# It also creates PDFs for other model SVG files in the same directory, such as the one for the parametrized response
# grammar.

# It requires that rsvg-convert be installed. On Linux, this can be done with `sudo apt-get install librsvg2-bin`

METAMODEL_PATH="modelingassistant/model"

# Show error and exit if rsvg-convert is not installed
if ! [ -x "$(command -v rsvg-convert)" ]; then
  echo "Error: rsvg-convert is not installed. Please install it and try again." >&2
  exit 1
fi

# Create a pdf with a similar name for each svg file in the metamodel folder
for svg in "$METAMODEL_PATH"/*.svg; do
    echo "Converting $svg to pdf"
    pdf="${svg%.svg}.pdf"
    rsvg-convert -f pdf -o $pdf $svg
done
