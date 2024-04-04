SRC_PATH = src

CLASSFILE_PATH = out

SCENARIO_FILE = scenario.txt

MAIN = Main

GREEN=\033[0;32m
RED=\033[0;31m
BLUE=\033[0;34m
END=\033[0m

all: compile run

compile:
	@echo "$(GREEN)Building project...$(END)"

	mkdir -p $(CLASSFILE_PATH)
	find $(SRC_PATH) -name "*.java" > sources.txt
	javac @sources.txt -d $(CLASSFILE_PATH)

run:
	@echo "$(BLUE)Running $(MAIN)...$(END)"
	java -cp $(CLASSFILE_PATH) $(MAIN) $(SCENARIO_FILE)

clean:
	@echo "$(RED)Cleaning project...$(END)"
	rm -rf $(CLASSFILE_PATH)

re: clean compile run