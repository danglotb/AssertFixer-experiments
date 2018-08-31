/**
 * Copyright (C) 2010-16 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rvesse.airline.io.output;

import java.io.OutputStream;

import com.github.rvesse.airline.io.colors.TrueColor;
import com.github.rvesse.airline.io.colors.sources.AnsiBackgroundColorSource;
import com.github.rvesse.airline.io.colors.sources.AnsiForegroundColorSource;

/**
 * A colorized output stream supporting ANSI true colour (24 bit i.e. 16 million
 * colours)
 * 
 * @author rvesse
 *
 */
public class AnsiTrueColorizedOutputStream extends ColorizedOutputStream<TrueColor> {

    public AnsiTrueColorizedOutputStream(OutputStream out) {
        super(out, new AnsiForegroundColorSource<TrueColor>(), new AnsiBackgroundColorSource<TrueColor>());
    }

}
