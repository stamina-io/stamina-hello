/*
 * Copyright (c) 2017 Stamina Framework developers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.staminaframework.hello.internal;

import io.staminaframework.runtime.command.Command;
import io.staminaframework.runtime.command.CommandConstants;
import org.osgi.service.component.annotations.Component;

import java.io.PrintStream;

/**
 * Simple command which outputs 'Hello %name!'.
 *
 * @author Stamina Framework developers
 */
@Component(service = Command.class, property = CommandConstants.COMMAND + "=hello")
public class HelloCommand implements Command {
    @Override
    public boolean execute(Command.Context ctx) throws Exception {
        final String name = ctx.arguments().length == 0 ? "world" : String.join(" ", ctx.arguments());
        ctx.out().println("Hello " + name + "!");
        return false;
    }

    @Override
    public void help(PrintStream out) {
        out.println("Show some greetings.");
        out.println("Usage: hello [<name>]");
    }
}
