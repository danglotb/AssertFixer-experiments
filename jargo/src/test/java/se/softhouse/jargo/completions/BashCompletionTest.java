/* Copyright 2018 jonatanjonsson
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package se.softhouse.jargo.completions;

import static java.util.Collections.emptyList;
import static org.fest.assertions.Assertions.assertThat;
import static se.softhouse.jargo.Arguments.enumArgument;
import static se.softhouse.jargo.Arguments.stringArgument;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Ignore;
import org.junit.Test;

import se.softhouse.common.strings.StringsUtil;
import se.softhouse.common.testlib.Launcher;
import se.softhouse.common.testlib.Launcher.LaunchedProgram;
import se.softhouse.jargo.Argument;
import se.softhouse.jargo.ArgumentExceptions;
import se.softhouse.jargo.CommandLineParser;
import se.softhouse.jargo.FakeCompleter;
import se.softhouse.jargo.commands.CommandWithArgument;
import se.softhouse.jargo.commands.Commit.Repository;
import se.softhouse.jargo.commands.Git;
import se.softhouse.jargo.stringparsers.EnumArgumentTest.Action;

/**
 * Tests that the correct words are suggested for {@link Completers#bashCompleter(Map, java.util.function.Consumer, Runnable)
 * bash-completion} support
 */
public class BashCompletionTest
{
	final CommandLineParser parser = CommandLineParser.withCommands(new Git(new Repository())).andArguments(Git.MESSAGE);

	List<String> currentDirFiles = Arrays.asList(new File(".").list());

	@Test
	public void testThatCommandNameIsCompletedCorrectly() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commi");
		assertThat(suggestions).containsOnly("commit ");

		suggestions = FakeCompleter.complete(parser, "git", "com");
		assertThat(suggestions).containsOnly("commit ");

		suggestions = FakeCompleter.complete(parser, "git", "lo");
		assertThat(suggestions).containsOnly("log ");

		suggestions = FakeCompleter.complete(parser, "--");
		assertThat(suggestions).containsOnly("--message ");

		suggestions = FakeCompleter.complete(parser, "");
		assertThat(suggestions).containsOnly("--message ", "-m ", "git ");

		suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=j", "--no");
		assertThat(suggestions).isEmpty();

		// TODO(jontejj): test that limiters are applied to completers
	}

	@Test
	public void testThatCompletingAnArgToACommandWorks() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--am");
		assertThat(suggestions).containsOnly("--amend ");
	}

	@Test
	public void testThatCompletingARequiredArgForACommandWorks() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--auth");
		assertThat(suggestions).containsOnly("--author=");
	}

	@Test
	public void testThatBothSubCommandsAndRegularArgAreSuggested() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "");
		assertThat(suggestions).containsOnly("commit ", "log ", "merge ", "--message ", "-m ");
	}

	@Test
	public void testThatArgsWithEqualsSeparatorAreNotSuggestedTwice() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=");
		assertThat(suggestions).isEmpty();
	}

	@Test
	public void testThatCommandsWithRequiredArgsBeingCompletedAreCompletedCorrectly() throws Exception
	{
		Argument<Action> action = enumArgument(Action.class, "-a").separator("=").required().build();
		CommandWithArgument<Action> commandWithArgument = new CommandWithArgument<>("command", action);

		CommandLineParser commandParser = CommandLineParser.withCommands(commandWithArgument);
		SortedSet<String> suggestions = FakeCompleter.complete(commandParser, "command", "-a=");
		assertThat(suggestions).containsOnly("start", "stop", "restart");
	}

	@Test
	public void testThatBothArgsAndVariableArgsAreSuggestedBeforeEnteringVariableArgs() throws Exception
	{
		TreeSet<String> expectedSuggestions = new TreeSet<>(currentDirFiles);
		// Does not contain --author as it's already parsed
		expectedSuggestions.addAll(Arrays.asList("--amend ", "--message ", "-m ", "log ", "merge "));

		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=j", "");
		assertThat(suggestions).isEqualTo(expectedSuggestions);

		// Once variable args have been given, no other args should be suggested
		suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=j", "file", "");
		assertThat(suggestions).isEqualTo(new TreeSet<>(currentDirFiles));
	}

	@Test
	public void testThatEmptyParameterWithNoCompletionsLeadsToNoSuggestions() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--message", "");
		assertThat(suggestions).isEmpty();
	}

	@Test
	public void testThatEmptyParameterWithNoCompletionsLeadsToNoSuggestionsAlsoAfterRequiredArgs() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=joj", "--message", "");
		assertThat(suggestions).isEmpty();
	}

	@Test
	public void testThatVariableArityArgsCanBeCompleted() throws Exception
	{
		CommandLineParser p = CommandLineParser.withArguments(enumArgument(Action.class).variableArity().build());
		SortedSet<String> suggestions = FakeCompleter.complete(p, "stop", "re");
		assertThat(suggestions).containsOnly("restart");
	}

	@Test
	public void testThatVariableArityArgsCanBeSuggestedSeveralTimes() throws Exception
	{
		SortedSet<String> suggestions = FakeCompleter.complete(parser, "git", "commit", "--author=j", "pom.xml", "");
		assertThat(suggestions).isEqualTo(new TreeSet<>(currentDirFiles));
	}

	@Test
	public void testThatCustomCompleterIsUsedInsteadOfDefault() throws Exception
	{
		CommandLineParser p = CommandLineParser.withArguments(enumArgument(Action.class)
				.completer((str) -> StringsUtil.prefixes(str, Collections.singleton("reab"))).variableArity().build());
		SortedSet<String> suggestions = FakeCompleter.complete(p, "stop", "re");
		assertThat(suggestions).containsOnly("reab");

		suggestions = FakeCompleter.complete(p, "stop", "restart", "r");
		assertThat(suggestions).containsOnly("reab");
	}

	public static void main(String[] args)
	{
		Argument<String> shouldNotParse = stringArgument("--comp").<String>transform((a) -> {
			if(a != null)
				throw ArgumentExceptions.withMessage("transform called");
			return a;
		}).build();
		Argument<String> stuff = stringArgument("--complete-me").build();
		CommandLineParser.withArguments(shouldNotParse, stuff).parse(args);
	}

	@Ignore("To be able to properly exclude already passed arguments from suggestions, parsing is necessary")
	@Test
	public void testThatCompleterExitsJargoProgramBeforeAnyParseTakesPlace() throws Exception
	{
		String[] args = {"--comp", "hello", "--compl"};
		Map<String, String> fakeEnv = FakeCompleter.fakeEnv("asda", " ", args);
		LaunchedProgram launchedProgram = Launcher.launch(emptyList(), fakeEnv, BashCompletionTest.class, args);
		assertThat(launchedProgram.errors()).isEmpty();
		assertThat(launchedProgram.exitCode()).isEqualTo(0);
		assertThat(launchedProgram.output()).isEqualTo("--complete-me " + System.lineSeparator());
	}
}
