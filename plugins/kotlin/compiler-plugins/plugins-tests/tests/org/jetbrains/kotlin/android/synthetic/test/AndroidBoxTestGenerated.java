/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.android.synthetic.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class AndroidBoxTestGenerated extends AbstractAndroidBoxTest {
    @TestMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Android extends AbstractAndroidBoxTest {
        public void testAllFilesPresentInAndroid() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("plugins/android-extensions/android-extensions-compiler/testData/codegen/android"), Pattern.compile("^([^\\.]+)$"), TargetBackend.ANY, false);
        }

        @TestMetadata("androidEntity")
        public void testAndroidEntity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/androidEntity/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("androidEntityInnerClass")
        public void testAndroidEntityInnerClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/androidEntityInnerClass/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("fqNameInAttr")
        public void testFqNameInAttr() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fqNameInAttr/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("fqNameInTag")
        public void testFqNameInTag() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fqNameInTag/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("fragment")
        public void testFragment() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fragment/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("fragmentNoGetView")
        public void testFragmentNoGetView() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fragmentNoGetView/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("manyWidgets")
        public void testManyWidgets() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/manyWidgets/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("multiFile")
        public void testMultiFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/multiFile/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("singleFile")
        public void testSingleFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/singleFile/");
            doCompileAgainstAndroidSdkTest(fileName);
        }

        @TestMetadata("view")
        public void testView() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/view/");
            doCompileAgainstAndroidSdkTest(fileName);
        }
    }

    @TestMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Invoke extends AbstractAndroidBoxTest {
        public void testAllFilesPresentInInvoke() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("plugins/android-extensions/android-extensions-compiler/testData/codegen/android"), Pattern.compile("^([^\\.]+)$"), TargetBackend.ANY, false);
        }

        @TestMetadata("androidEntity")
        public void testAndroidEntity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/androidEntity/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("androidEntityInnerClass")
        public void testAndroidEntityInnerClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/androidEntityInnerClass/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("fqNameInAttr")
        public void testFqNameInAttr() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fqNameInAttr/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("fqNameInTag")
        public void testFqNameInTag() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fqNameInTag/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("fragment")
        public void testFragment() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fragment/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("fragmentNoGetView")
        public void testFragmentNoGetView() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/fragmentNoGetView/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("manyWidgets")
        public void testManyWidgets() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/manyWidgets/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("multiFile")
        public void testMultiFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/multiFile/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("singleFile")
        public void testSingleFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/singleFile/");
            doFakeInvocationTest(fileName);
        }

        @TestMetadata("view")
        public void testView() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("plugins/android-extensions/android-extensions-compiler/testData/codegen/android/view/");
            doFakeInvocationTest(fileName);
        }
    }
}
