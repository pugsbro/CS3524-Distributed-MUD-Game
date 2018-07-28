#!/bin/bash
enscript -2 -r -Ejava -o - MUDclient.java | ps2pdf - MUDclient.pdf

enscript -2 -r -Ejava -o - MUDserver.java | ps2pdf - MUDserver.pdf

enscript -2 -r -Ejava -o - MUDinterface.java | ps2pdf - MUDinterface.pdf

enscript -2 -r -Ejava -o - MUDServiceImplementation.java | ps2pdf - MUDServiceImplementation.pdf

enscript -2 -r -Ejava -o - Edge.java | ps2pdf - Edge.pdf 

enscript -2 -r -Ejava -o - Vertex.java | ps2pdf - Vertex.pdf

enscript -2 -r -Ejava -o - MUD.java | ps2pdf - MUD.pdf

